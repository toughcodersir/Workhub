import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { adminLogin } from "./adminService";   // ✅ FINAL CORRECT PATH

const AdminLogin = () => {
  const [form, setForm] = useState({ email: "", password: "" });
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const handleChange = (e) =>
    setForm({ ...form, [e.target.name]: e.target.value });

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError(""); // reset error message

    try {
      const res = await adminLogin(form);

      // backend returns null if invalid login
      if (!res.data || !res.data.email) {
        setError("Invalid email or password.");
        return;
      }

      // SUCCESS → Save login
      localStorage.setItem("admin", JSON.stringify(res.data));

      navigate("/admin"); // 🚀 redirect to dashboard
    } catch (err) {
      console.error(err);
      setError("Login failed. Please try again.");
    }
  };

  return (
    <div className="page-container">
      <h2>Admin Login</h2>

      {error && (
        <div style={{ color: "red", fontWeight: "bold", marginBottom: "10px" }}>
          {error}
        </div>
      )}

      <form onSubmit={handleSubmit} className="form">
        <label>Email</label>
        <input
          name="email"
          type="email"
          value={form.email}
          onChange={handleChange}
          required
        />

        <label>Password</label>
        <input
          name="password"
          type="password"
          value={form.password}
          onChange={handleChange}
          required
        />

        <button type="submit">Login</button>
      </form>
    </div>
  );
};

export default AdminLogin;
