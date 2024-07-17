document.addEventListener('DOMContentLoaded', () => {

    const form = document.querySelector('form');
    const messageContainer = document.querySelector('p');
    const modal = document.getElementById('userModal');
    const closeModalBtn = document.querySelector('.close');
    const userInfo = document.getElementById('userInfo');

    form.addEventListener('submit', async (event) => {

        event.preventDefault(); 

        const formData = new FormData(form);
        const data = {
            name: formData.get('name'),
            lastName: formData.get('lastName'),
            email: formData.get('email')
        };

        try {
            const response = await fetch('/form', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data)
            });

            if (response.ok) {
                const result = await response.text();
                messageContainer.textContent = result;
                form.reset();

                userInfo.innerHTML = `<strong>Name:</strong> ${data.name} <br> <strong>last Name:</strong> ${data.lastName} <br> <strong>Email:</strong> ${data.email}`;
                modal.style.display = 'block';
            } else {
                messageContainer.textContent = 'Error saving user!';
            }
        } catch (error) {
            messageContainer.textContent = 'Error saving user!';
            console.error('Error:', error);
        }
    });

    closeModalBtn.addEventListener('click', () => {
        modal.style.display = 'none';
    });

    window.addEventListener('click', (event) => {
        if (event.target === modal) {
            modal.style.display = 'none';
        }
    });
});
