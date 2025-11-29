import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { adminRegister } from "./adminService";

const AdminRegister = () => {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await adminRegister({ name, email, password });
      alert("Registered. Login now.");
      navigate("/admin/login");
    } catch (err) {
      console.error(err);
      alert("Register failed.");
    }
  };

  return (
    <div className="page-container">
      <h2>Admin Register</h2>
      <form onSubmit={handleSubmit} className="form">
        <label>Name</label>
        <input value={name} onChange={(e) => setName(e.target.value)} required />
        <label>Email</label>
        <input value={email} onChange={(e) => setEmail(e.target.value)} required />
        <label>Password</label>
        <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} required />
        <button type="submit">Register</button>
      </form>
    </div>
  );
};

export default AdminRegister;
