import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { createBatch } from "../adminService";

const BatchAdd = () => {
  const [form, setForm] = useState({
    batchName: "",
    mentorName: "",
    technologies: "",
    startDate: "",
    endDate: "",
    status: ""
  });

  const navigate = useNavigate();

  const handleChange = (e) =>
    setForm({ ...form, [e.target.name]: e.target.value });

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      await createBatch(form);
      alert("Batch created successfully!");
      navigate("/admin/batches");
    } catch (err) {
      console.error(err);
      alert("Failed to create batch. Check backend logs.");
    }
  };

  return (
    <div className="page-container">
      <h2>Add Batch</h2>

      <form onSubmit={handleSubmit} className="form">

        <label>Batch Name</label>
        <input
          name="batchName"
          value={form.batchName}
          onChange={handleChange}
          required
          className="form-control"
        />

        <label>Mentor Name</label>
        <input
          name="mentorName"
          value={form.mentorName}
          onChange={handleChange}
          className="form-control"
        />

        <label>Technologies</label>
        <input
          name="technologies"
          value={form.technologies}
          onChange={handleChange}
          className="form-control"
        />

        <label>Start Date</label>
        <input
          name="startDate"
          type="date"
          value={form.startDate}
          onChange={handleChange}
          className="form-control"
        />

        <label>End Date</label>
        <input
          name="endDate"
          type="date"
          value={form.endDate}
          onChange={handleChange}
          className="form-control"
        />

        <label>Status</label>
        <input
          name="status"
          value={form.status}
          onChange={handleChange}
          placeholder="In-progress / Completed / To be started"
          className="form-control"
        />

        <button type="submit" className="btn btn-primary mt-3">
          Save
        </button>

      </form>
    </div>
  );
};

export default BatchAdd;
