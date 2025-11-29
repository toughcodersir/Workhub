import React, { useEffect, useState } from "react";
import axios from "axios";

function EducationSection({ employeeId }) {
  const [records, setRecords] = useState([]);

  const [form, setForm] = useState({
    degree: "",
    institution: "",
    yearOfPassing: "",
    percentageOrCgpa: "",
  });

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  useEffect(() => {
    axios
      .get(`http://localhost:8080/api/education/employee/${employeeId}`)
      .then((res) => setRecords(res.data))
      .catch(() => {});
  }, [employeeId]);

  const handleAdd = (e) => {
    e.preventDefault();

    axios
      .post(`http://localhost:8080/api/education/${employeeId}`, form)
      .then((res) => {
        setRecords([...records, res.data]);
        setForm({
          degree: "",
          institution: "",
          yearOfPassing: "",
          percentageOrCgpa: "",
        });
      })
      .catch(() => alert("Failed to add education"));
  };

  const handleDelete = (id) => {
    axios
      .delete(`http://localhost:8080/api/education/${id}`)
      .then(() => setRecords(records.filter((r) => r.educationId !== id)))
      .catch(() => alert("Delete failed"));
  };

  return (
    <div className="card p-3 mb-3">
      <h5>Education</h5>

      <form onSubmit={handleAdd} className="mb-3">
        <div className="row">
          <div className="col-md-6">
            <label>Degree</label>
            <input className="form-control" name="degree" value={form.degree} onChange={handleChange} required />
          </div>

          <div className="col-md-6">
            <label>Institution</label>
            <input className="form-control" name="institution" value={form.institution} onChange={handleChange} required />
          </div>
        </div>

        <div className="row mt-2">
          <div className="col-md-6">
            <label>Year of Passing</label>
            <input className="form-control" name="yearOfPassing" value={form.yearOfPassing} onChange={handleChange} />
          </div>

          <div className="col-md-6">
            <label>Percentage/CGPA</label>
            <input className="form-control" name="percentageOrCgpa" value={form.percentageOrCgpa} onChange={handleChange} />
          </div>
        </div>

        <button className="btn btn-success mt-3">Add Education</button>
      </form>

      <table className="table table-bordered">
        <thead className="table-dark">
          <tr>
            <th>Degree</th>
            <th>Institution</th>
            <th>Year</th>
            <th>Percentage</th>
            <th>Actions</th>
          </tr>
        </thead>

        <tbody>
          {records.map((r) => (
            <tr key={r.educationId}>
              <td>{r.degree}</td>
              <td>{r.institution}</td>
              <td>{r.yearOfPassing}</td>
              <td>{r.percentageOrCgpa}</td>
              <td>
                <button className="btn btn-danger btn-sm" onClick={() => handleDelete(r.educationId)}>
                  Delete
                </button>
              </td>
            </tr>
          ))}

          {records.length === 0 && (
            <tr>
              <td colSpan="5" className="text-center">No education added yet.</td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
}

export default EducationSection;
