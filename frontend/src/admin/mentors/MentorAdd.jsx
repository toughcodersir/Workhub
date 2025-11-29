import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { createMentor } from "../adminService";

const MentorAdd = () => {
  const [form, setForm] = useState({
    name: "",
    email: "",
    phone: "",
    expertise: "",
    experience: ""
  });

  const navigate = useNavigate();

  const handleChange = (e) =>
    setForm({ ...form, [e.target.name]: e.target.value });

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      await createMentor(form);
      alert("Mentor added successfully!");
      navigate("/admin/mentors");
    } catch (err) {
      console.error(err);
      alert("Failed to create mentor");
    }
  };

  return (
    <div className="page-container">
      <h2>Add Mentor</h2>

      <form onSubmit={handleSubmit} className="form">

        <label>Name</label>
        <input
          name="name"
          value={form.name}
          onChange={handleChange}
          required
        />

        <label>Email</label>
        <input
          name="email"
          type="email"
          value={form.email}
          onChange={handleChange}
        />

        <label>Phone</label>
        <input
          name="phone"
          value={form.phone}
          onChange={handleChange}
        />

        <label>Expertise</label>
        <input
          name="expertise"
          value={form.expertise}
          onChange={handleChange}
        />

        <label>Experience</label>
        <input
          name="experience"
          value={form.experience}
          onChange={handleChange}
        />

        <button type="submit">Save</button>

      </form>
    </div>
  );
};

export default MentorAdd;
