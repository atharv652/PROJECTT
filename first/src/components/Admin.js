import React from "react";

export default function Admin() {
    const tableStyle = {
        borderCollapse: 'collapse',
        width: '100%',
        border: '1px solid black',
        marginTop: '20px',
    };

    const cellStyle = {
        border: '1px solid black',
        padding: '8px',
        textAlign: 'center',
    };

    const headingStyle = {
        fontSize: '24px',
        marginBottom: '10px',
    };

    return (
        <div style={styles.container}>
            <h1 style={headingStyle}>Welcome Admin</h1>
            <h2 style={styles.subHeading}>Stock Management</h2>
            <table style={tableStyle}>
                <tbody>
                    <tr>
                        <td style={cellStyle}>Sr. No</td>
                        <td style={cellStyle}>Blood Group</td>
                        <td style={cellStyle}>Quantity(in bags)</td>
                        <td style={cellStyle}>Date of Receiving</td>
                        <td style={cellStyle}>Expiry Date</td>
                        <td style={cellStyle}>Location</td>
                    </tr>
                    <tr>
                        <td style={cellStyle}>1.</td>
                        <td style={cellStyle}>A+</td>
                        <td style={cellStyle}>4</td>
                        <td style={cellStyle}>10-08-2023</td>
                        <td style={cellStyle}>21-09-2023</td>
                        <td style={cellStyle}>Jehangir, Pune</td>
                    </tr>
                </tbody>
            </table>
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
        maxWidth: '800px',
        margin: '0 auto',
    },
    subHeading: {
        fontSize: '20px',
        marginBottom: '20px',
    },
};
