import React from 'react';

export default function CheckAvailabilityUI() {
    return (
        <div style={styles.container}>
            <h1 style={styles.heading}>Check Blood Availability</h1>
            <label style={styles.label}>Select Blood Type:</label>
            <select style={styles.select}>
                <option value="A+">A+</option>
                <option value="B+">B+</option>
                <option value="O+">O+</option>
                <option value="A-">A-</option>
                <option value="B-">B-</option>
                <option value="O-">O-</option>
                <option value="AB-">AB-</option>
                <option value="AB+">AB+</option>
            </select>
            <button style={styles.button}>Check Availability</button>
            <div style={styles.info}>
                <p>Available units: 5</p>
            </div>
        </div>
    );
}

const styles = {
    container: {
        textAlign: 'center',
        padding: '20px',
        border: '1px solid #ccc',
        borderRadius: '8px',
        boxShadow: '0px 2px 4px rgba(0, 0, 0, 0.1)',
        maxWidth: '400px',
        margin: '0 auto',
    },
    heading: {
        fontSize: '24px',
        marginBottom: '10px',
    },
    label: {
        display: 'block',
        marginBottom: '6px',
        fontSize: '16px',
        fontWeight: 'bold',
    },
    select: {
        width: '100%',
        padding: '8px',
        marginBottom: '20px',
        fontSize: '14px',
    },
    button: {
        padding: '10px 20px',
        backgroundColor: '#007BFF',
        color: 'white',
        border: 'none',
        borderRadius: '4px',
        cursor: 'pointer',
        fontSize: '16px',
    },
    info: {
        marginTop: '20px',
        fontSize: '14px',
    },
};
