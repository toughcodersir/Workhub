import React, { useEffect, useState } from "react";
import axios from "axios";

function TemporaryAddressSection({ employeeId }) {
  const [form, setForm] = useState({
    houseNumber: "",
    street: "",
    city: "",
    state: "",
    country: "",
    pincode: "",
  });

  useEffect(() => {
    axios
      .get(`http://localhost:8080/api/employees/${employeeId}/temporary-address`)
      .then((res) => {
        if (res.data) setForm(res.data);
      })
      .catch(() => {});
  }, [employeeId]);

  const handleChange = (e) =>
    setForm({ ...form, [e.target.name]: e.target.value });

  const handleSave = (e) => {
    e.preventDefault();

    axios
      .post(`http://localhost:8080/api/employees/${employeeId}/temporary-address`, form)
      .then(() => alert("Temporary Address Saved"))
      .catch(() => alert("Failed to save temporary address"));
  };

  return (
    <div className="card p-3 mb-3">
      <h5>Temporary Address</h5>
      <form onSubmit={handleSave}>
        <label>House Number</label>
        <input className="form-control" name="houseNumber" value={form.houseNumber} onChange={handleChange} />

        <label className="mt-2">Street</label>
        <input className="form-control" name="street" value={form.street} onChange={handleChange} />

        <label className="mt-2">City</label>
        <input className="form-control" name="city" value={form.city} onChange={handleChange} />

        <label className="mt-2">State</label>
        <input className="form-control" name="state" value={form.state} onChange={handleChange} />

        <label className="mt-2">Country</label>
        <input className="form-control" name="country" value={form.country} onChange={handleChange} />

        <label className="mt-2">Pincode</label>
        <input className="form-control" name="pincode" value={form.pincode} onChange={handleChange} />

        <button className="btn btn-success mt-3">Save</button>
      </form>
    </div>
  );
}

export default TemporaryAddressSection;
