import React, { useState } from 'react';

function SignUp(){
    const [formData, setFormData] = useState(
        {
            username: '',
            userPassword: '',
            email:'',
            firstName: '',
            lastName: ''
        }
    )
    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        const {username, userPassword, email, firstName, lastName} = this.state;
        // You can send the signup data to your server here
        try {
            const response = await fetch('http://localhost:8080/users', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(formData),
            });

            if (response.ok) {
                // Request was successful, you can handle the response data here
                const responseData = await response.json();
                console.log('Response Data:', responseData);
            } else {
                // Handle errors here
                console.error('Error:', response.statusText);
            }
        } catch (error) {
            console.error('Fetch Error:', error);
        }
    };

    return (
        <div>
            <h1>Sign Up</h1>
            <form onSubmit={handleSubmit}>
                <label>
                    Username:
                    <input
                        type="text"
                        name="username"
                        value={formData.username}
                        onChange={handleInputChange}
                        required
                    />
                </label>
                <br />
                <label>
                    Password:
                    <input
                        type="password"
                        name="userPassword"
                        value={formData.userPassword}
                        onChange={handleInputChange}
                        required
                    />
                </label>
                <br />
                <label>
                    Email:
                    <input
                        type="email"
                        name="email"
                        value={formData.email}
                        onChange={handleInputChange}
                        required
                    />
                </label>
                <br />
                <label>
                    First Name:
                    <input
                        type="text"
                        name="firstName"
                        value={formData.firstName}
                        onChange={handleInputChange}
                        required
                    />
                </label>
                <br />
                <label>
                    Last Name:
                    <input
                        type="text"
                        name="lastName"
                        value={formData.lastName}
                        onChange={handleInputChange}
                        required
                    />
                </label>
                <br />
                <button type="submit">Sign Up</button>
            </form>
        </div>
    );
}

const container = document.getElementById('signUp')
const root = ReactDOM.createRoot(container);
root.render(<SignUp/>);