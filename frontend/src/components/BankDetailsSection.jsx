import React, { useEffect, useState } from "react";
import axios from "axios";

function BankDetailsSection({ employeeId }) {
  const [form, setForm] = useState({
    accountNumber: "",
    bankName: "",
    ifscCode: "",
    branchName: "",
  });

  const [bank, setBank] = useState(null);

  useEffect(() => {
    axios
      .get(`http://localhost:8080/api/bank/${employeeId}`)
      .then((res) => {
        if (res.data) {
          setBank(res.data);
          setForm(res.data);
        }
      })
      .catch(() => {});
  }, [employeeId]);

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSave = (e) => {
    e.preventDefault();

    axios
      .post(`http://localhost:8080/api/bank/${employeeId}`, form)
      .then(() => alert("Bank details saved"))
      .catch(() => alert("Failed to save bank details"));
  };

  return (
    <div className="card p-3 mb-3">
      <h5>Bank Details</h5>
      <form onSubmit={handleSave}>
        <label>Account Number</label>
        <input className="form-control" name="accountNumber" value={form.accountNumber} onChange={handleChange} />

        <label className="mt-2">Bank Name</label>
        <input className="form-control" name="bankName" value={form.bankName} onChange={handleChange} />

        <label className="mt-2">IFSC Code</label>
        <input className="form-control" name="ifscCode" value={form.ifscCode} onChange={handleChange} />

        <label className="mt-2">Branch</label>
        <input className="form-control" name="branchName" value={form.branchName} onChange={handleChange} />

        <button className="btn btn-success mt-3">Save</button>
      </form>
    </div>
  );
}

export default BankDetailsSection;
