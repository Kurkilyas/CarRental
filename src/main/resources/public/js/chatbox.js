document.addEventListener('DOMContentLoaded', function() {
    const chatBox = document.getElementById('chatBox');
    const openButton = document.getElementById('openChat');
    const closeButton = document.getElementById('closeChat');
    const messageInput = document.getElementById('messageInput');
    const sendButton = document.getElementById('sendMessage');
    const chatMessages = document.getElementById('chatMessages');

    openButton.addEventListener('click', function() {
        chatBox.style.display = 'flex';
        openButton.style.display = 'none';
    });

    closeButton.addEventListener('click', function() {
        chatBox.style.display = 'none';
        openButton.style.display = 'block';
    });

    sendButton.addEventListener('click', sendMessage);
    messageInput.addEventListener('keypress', function(e) {
        if (e.key === 'Enter') {
            sendMessage();
        }
    });

    async function sendMessage() {
        const messageText = messageInput.value.trim();
        if (messageText) {
            addMessage(messageText, 'user');
            messageInput.value = '';

            try {
                const response = await fetch('http://localhost:8090/api/chat/send', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'text/plain',
                    },
                    body: messageText
                });

                if (response.ok) {
                    const botResponse = await response.text();
                    addMessage(botResponse, 'bot');
                } else {
                    console.error('Server error:', await response.text());
                    addMessage('Sorry, an error occurred.', 'bot');
                }
            } catch (error) {
                console.error('Error:', error);
                addMessage('Sorry, an error occurred.', 'bot');
            }
        }
    }

    function addMessage(message, type) {
        const messageDiv = document.createElement('div');
        messageDiv.classList.add('message');
        messageDiv.classList.add(type + '-message');
        messageDiv.textContent = message;
        chatMessages.appendChild(messageDiv);
        chatMessages.scrollTop = chatMessages.scrollHeight;
    }
});