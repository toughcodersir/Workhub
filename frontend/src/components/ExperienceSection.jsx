import React, { useEffect, useState } from "react";
import axios from "axios";

function ExperienceSection({ employeeId }) {
  const [records, setRecords] = useState([]);

  const [form, setForm] = useState({
    companyName: "",
    jobTitle: "",
    startDate: "",
    endDate: "",
    yearsOfExperience: "",
    technologiesUsed: "",
  });

  const handleChange = (e) =>
    setForm({ ...form, [e.target.name]: e.target.value });

  useEffect(() => {
    axios
      .get(`http://localhost:8080/api/experience/employee/${employeeId}`)
      .then((res) => setRecords(res.data))
      .catch(() => {});
  }, [employeeId]);

  const handleAdd = (e) => {
    e.preventDefault();

    axios
      .post(`http://localhost:8080/api/experience/employee/${employeeId}`, form)
      .then((res) => {
        setRecords([...records, res.data]);
        setForm({
          companyName: "",
          jobTitle: "",
          startDate: "",
          endDate: "",
          yearsOfExperience: "",
          technologiesUsed: "",
        });
      })
      .catch(() => alert("Failed to add experience"));
  };

  const handleDelete = (id) => {
    axios
      .delete(`http://localhost:8080/api/experience/${id}`)
      .then(() => setRecords(records.filter((r) => r.experienceId !== id)))
      .catch(() => alert("Delete failed"));
  };

  return (
    <div className="card p-3 mb-3">
      <h5>Experience</h5>

      <form onSubmit={handleAdd} className="mb-3">
        <div className="row">
          <div className="col-md-6">
            <label>Company Name</label>
            <input className="form-control" name="companyName" value={form.companyName} onChange={handleChange} />
          </div>

          <div className="col-md-6">
            <label>Job Title</label>
            <input className="form-control" name="jobTitle" value={form.jobTitle} onChange={handleChange} />
          </div>
        </div>

        <div className="row mt-2">
          <div className="col-md-6">
            <label>Start Date</label>
            <input type="date" className="form-control" name="startDate" value={form.startDate} onChange={handleChange} />
          </div>

          <div className="col-md-6">
            <label>End Date</label>
            <input type="date" className="form-control" name="endDate" value={form.endDate} onChange={handleChange} />
          </div>
        </div>

        <label className="mt-2">Years of Experience</label>
        <input className="form-control" name="yearsOfExperience" value={form.yearsOfExperience} onChange={handleChange} />

        <label className="mt-2">Technologies Used</label>
        <input className="form-control" name="technologiesUsed" value={form.technologiesUsed} onChange={handleChange} />

        <button className="btn btn-success mt-3">Add Experience</button>
      </form>

      <table className="table table-bordered">
        <thead className="table-dark">
          <tr>
            <th>Company</th>
            <th>Job Title</th>
            <th>Start</th>
            <th>End</th>
            <th>Years</th>
            <th>Tech Used</th>
            <th>Actions</th>
          </tr>
        </thead>

        <tbody>
          {records.map((r) => (
            <tr key={r.experienceId}>
              <td>{r.companyName}</td>
              <td>{r.jobTitle}</td>
              <td>{r.startDate}</td>
              <td>{r.endDate}</td>
              <td>{r.yearsOfExperience}</td>
              <td>{r.technologiesUsed}</td>
              <td>
                <button className="btn btn-danger btn-sm" onClick={() => handleDelete(r.experienceId)}>
                  Delete
                </button>
              </td>
            </tr>
          ))}

          {records.length === 0 && (
            <tr><td colSpan="7" className="text-center">No experience added yet.</td></tr>
          )}
        </tbody>
      </table>
    </div>
  );
}

export default ExperienceSection;
