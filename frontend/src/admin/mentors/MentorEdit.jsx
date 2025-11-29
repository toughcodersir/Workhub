import React, { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { getMentorById, updateMentor } from "../adminService";

const MentorEdit = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const [form, setForm] = useState(null);

  useEffect(() => {
    const loadData = async () => {
      try {
        const res = await getMentorById(id);
        setForm(res.data);
      } catch (err) {
        console.error(err);
        alert("Failed to load mentor details.");
      }
    };
    loadData();
  }, [id]);

  if (!form) return <div>Loading...</div>;

  const handleChange = (e) =>
    setForm({ ...form, [e.target.name]: e.target.value });

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      await updateMentor(id, form);
      alert("Mentor updated successfully!");
      navigate("/admin/mentors");
    } catch (err) {
      console.error(err);
      alert("Update failed. Check backend logs.");
    }
  };

  return (
    <div className="page-container">
      <h2>Edit Mentor</h2>

      <form onSubmit={handleSubmit} className="form">

        <label>Name</label>
        <input
          name="name"
          value={form.name || ""}
          onChange={handleChange}
          required
          className="form-control"
        />

        <label>Email</label>
        <input
          name="email"
          type="email"
          value={form.email || ""}
          onChange={handleChange}
          className="form-control"
        />

        <label>Skills</label>
        <input
          name="skills"
          value={form.skills || ""}
          onChange={handleChange}
          className="form-control"
        />

        <button type="submit" className="btn btn-primary mt-3">
          Save
        </button>

      </form>
    </div>
  );
};

export default MentorEdit;
