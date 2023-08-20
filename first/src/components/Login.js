import React from 'react';
import './Login.css'; // Import the CSS file

import pic from '../staticSources/bgblood.jpg'; // Replace with the actual image path

export default function Login() {
    const containerStyle = {
        backgroundImage: `url(${pic})`, 
        backgroundSize: '100% 100%', 
        backgroundPosition: 'center',
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'flex-start',
        height: '100vh',
    };

    const formStyle = {
        border: '2px solid #ccc',
        padding: '20px',
        borderRadius: '5px',
        boxShadow: '0px 0px 10px rgba(0, 0, 0, 0.1)',
        backgroundColor: 'rgba(255, 255, 255, 0.8)',
        width: '300px',
        textAlign: 'center',
    };

    return (
        <div className="container" style={containerStyle}>
            <form style={formStyle}>
                User Id : <input type="text" name="username"/><br/>
                Password : <input type="password" name="pwd"/><br/>
                Select Role : <select>
                    <option>---select role---</option>
                    <option>Admin</option>
                    <option>Receiver</option>
                    <option>Donor</option>
                </select><br/>
                <input type="submit" value="Login"/>
                <input type="reset" value="Clear"/><br/>
                <a href=" ">Forgot Password?</a>
            </form>
        </div>
    );
}
