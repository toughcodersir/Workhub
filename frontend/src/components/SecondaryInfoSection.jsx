import React, { useEffect, useState } from "react";
import axios from "axios";

function SecondaryInfoSection({ employeeId }) {
  const [secondary, setSecondary] = useState(null);

  const [form, setForm] = useState({
    fatherName: "",
    motherName: "",
    bloodGroup: "",
    maritalStatus: "",
    aadhaarNumber: "",
    panNumber: "",
    emergencyContactName: "",
    emergencyContactNumber: "",
  });

  const [loading, setLoading] = useState(true);

  useEffect(() => {
    axios
      .get(`http://localhost:8080/api/employees/${employeeId}/secondary`)
      .then((res) => {
        if (res.data) {
          setSecondary(res.data);
          setForm(res.data);
        }
      })
      .catch(() => {})
      .finally(() => setLoading(false));
  }, [employeeId]);

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSave = (e) => {
    e.preventDefault();

    const url = secondary
      ? `http://localhost:8080/api/employees/${employeeId}/secondary`
      : `http://localhost:8080/api/employees/${employeeId}/secondary`;

    axios
      .post(url, form)
      .then(() => alert("Secondary info saved"))
      .catch(() => alert("Failed to save"));
  };

  if (loading) return <p>Loading Secondary Info...</p>;

  return (
    <div className="card p-3 mb-3">
      <h5>Secondary Information</h5>
      <form onSubmit={handleSave}>
        <div className="row">
          <div className="col-md-6">
            <label>Father Name</label>
            <input className="form-control" name="fatherName" value={form.fatherName} onChange={handleChange} />
          </div>

          <div className="col-md-6">
            <label>Mother Name</label>
            <input className="form-control" name="motherName" value={form.motherName} onChange={handleChange} />
          </div>
        </div>

        <div className="row mt-2">
          <div className="col-md-6">
            <label>Blood Group</label>
            <input className="form-control" name="bloodGroup" value={form.bloodGroup} onChange={handleChange} />
          </div>

          <div className="col-md-6">
            <label>Marital Status</label>
            <input className="form-control" name="maritalStatus" value={form.maritalStatus} onChange={handleChange} />
          </div>
        </div>

        <div className="row mt-2">
          <div className="col-md-6">
            <label>Aadhaar Number</label>
            <input className="form-control" name="aadhaarNumber" value={form.aadhaarNumber} onChange={handleChange} />
          </div>

          <div className="col-md-6">
            <label>PAN Number</label>
            <input className="form-control" name="panNumber" value={form.panNumber} onChange={handleChange} />
          </div>
        </div>

        <div className="row mt-2">
          <div className="col-md-6">
            <label>Emergency Contact Name</label>
            <input className="form-control" name="emergencyContactName" value={form.emergencyContactName} onChange={handleChange} />
          </div>

          <div className="col-md-6">
            <label>Emergency Contact Number</label>
            <input className="form-control" name="emergencyContactNumber" value={form.emergencyContactNumber} onChange={handleChange} />
          </div>
        </div>

        <button className="btn btn-success mt-3">Save</button>
      </form>
    </div>
  );
}

export default SecondaryInfoSection;
