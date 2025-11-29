import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function EmployeeAdd() {
  const navigate = useNavigate();

  const [employee, setEmployee] = useState({
    firstName: "",
    lastName: "",
    email: "",
    phone: "",
    gender: "",
    designation: "",
    status: "",
    dateOfBirth: "",
    joiningDate: "",
  });

  const handleChange = (e) => {
    setEmployee({ ...employee, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    // Convert dates to correct format for backend
    const payload = {
      ...employee,
      dateOfBirth: employee.dateOfBirth || null,
      joiningDate: employee.joiningDate || null,
    };

    axios
      .post("http://localhost:8080/api/employees", payload)
      .then(() => {
        alert("Employee added successfully!");
        navigate("/employees");
      })
      .catch((err) => {
        console.error("Save Failed:", err);
        alert("Error while saving employee.");
      });
  };

  return (
    <div className="card p-4">
      <h3>Add Employee</h3>
      <form onSubmit={handleSubmit}>
        
        <div className="row">
          <div className="col-md-6 mb-3">
            <label>First Name</label>
            <input name="firstName" className="form-control" onChange={handleChange} required />
          </div>

          <div className="col-md-6 mb-3">
            <label>Last Name</label>
            <input name="lastName" className="form-control" onChange={handleChange} required />
          </div>
        </div>

        <div className="mb-3">
          <label>Email</label>
          <input name="email" className="form-control" onChange={handleChange} required />
        </div>

        <div className="mb-3">
          <label>Phone</label>
          <input name="phone" className="form-control" onChange={handleChange} required />
        </div>

        <div className="row">
          <div className="col-md-6 mb-3">
            <label>Gender</label>
            <input name="gender" className="form-control" onChange={handleChange} />
          </div>

          <div className="col-md-6 mb-3">
            <label>Designation</label>
            <input name="designation" className="form-control" onChange={handleChange} />
          </div>
        </div>

        <div className="mb-3">
          <label>Status</label>
          <input name="status" className="form-control" onChange={handleChange} />
        </div>

        <div className="row">
          <div className="col-md-6 mb-3">
            <label>Date of Birth</label>
            <input type="date" name="dateOfBirth" className="form-control" onChange={handleChange} />
          </div>
          <div className="col-md-6 mb-3">
            <label>Joining Date</label>
            <input type="date" name="joiningDate" className="form-control" onChange={handleChange} />
          </div>
        </div>

        <button type="submit" className="btn btn-success">Save</button>
      </form>
    </div>
  );
}

export default EmployeeAdd;
