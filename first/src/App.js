import React from 'react';
import { Link, Route, Routes } from 'react-router-dom';
import './App.css';
import Login from './components/Login';
import Registration from './components/Registration';
import Home from './components/Home';
import Receiver from './components/Reciever';
import Donor from './components/Donor';
import Admin from './components/Admin';
import Contact from './components/Contact';

function App() {
  const handleLogout = () => {
    // Add your logout logic here
    // For example: Clear user session, redirect to login, etc.
  };

  return (
    <div className="App">
      <nav className="navbar navbar-expand-sm bg-light navbar-sm mb-3">
        <div className="container-fluid">
          <ul className="navbar-nav">
            <li className="nav-item">
              <Link to="home" className="nav-link px-3">
                Home
              </Link>
            </li>
            <li className="nav-item">
              <Link to="registration" className="nav-link px-3">
                Registration
              </Link>
            </li>
            <li className="nav-item">
              <Link to="login" className="nav-link px-3">
                Login
              </Link>
            </li>
            <li className="nav-item">
              <Link to="receiver" className="nav-link px-3">
                Check Availability
              </Link>
            </li>
            <li className="nav-item">
              <Link to="donor" className="nav-link px-3">
                Donation Camps
              </Link>
            </li>
            <li className="nav-item">
              <Link to="admin" className="nav-link px-3">
                Admin
              </Link>
            </li>
            <li className="nav-item">
              <Link to="contact" className="nav-link px-3">
                Contact Us
              </Link>
            </li>
          </ul>
          <ul className="navbar-nav ms-auto">
            <li className="nav-item">
              <button className="btn nav-link px-3" onClick={handleLogout}>
                Logout
              </button>
            </li>
          </ul>
        </div>
      </nav>
      <Routes>
        <Route path="home" element={<Home />} />
        <Route path="registration" element={<Registration />} />
        <Route path="login" element={<Login />} />
        <Route path="receiver" element={<Receiver />} />
        <Route path="donor" element={<Donor />} />
        <Route path="admin" element={<Admin />} />
        <Route path="contact" element={<Contact />} />
      </Routes>
    </div>
  );
}

export default App;
