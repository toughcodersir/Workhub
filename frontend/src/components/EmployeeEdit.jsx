import React, { useEffect, useState } from "react";
import axios from "axios";
import { useNavigate, useParams } from "react-router-dom";

function EmployeeEdit() {
  const { id } = useParams();
  const navigate = useNavigate();

  const [employee, setEmployee] = useState({
    firstName: "",
    lastName: "",
    email: "",
    phone: "",
    gender: "",
    designation: "",
    status: "",
  });

  useEffect(() => {
    axios
      .get(`http://localhost:8080/api/employees/${id}`)
      .then((res) => {
        const data = res.data;
        setEmployee({
          firstName: data.firstName || "",
          lastName: data.lastName || "",
          email: data.email || "",
          phone: data.phone || "",
          gender: data.gender || "",
          designation: data.designation || "",
          status: data.status || "",
        });
      })
      .catch((err) => {
        console.error(err);
        alert("Unable to fetch employee details");
      });
  }, [id]);

  const handleChange = (e) => {
    setEmployee({ ...employee, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    axios
      .put(`http://localhost:8080/api/employees/${id}`, employee)
      .then(() => {
        alert("Employee updated successfully!");
        navigate("/employees");
      })
      .catch((err) => {
        console.error(err);
        alert("Update failed!");
      });
  };

  return (
    <div className="card p-4">
      <h3>Edit Employee</h3>

      <form onSubmit={handleSubmit}>
        
        <div className="row">
          <div className="col-md-6 mb-3">
            <label>First Name</label>
            <input
              name="firstName"
              className="form-control"
              value={employee.firstName}
              onChange={handleChange}
              required
            />
          </div>

          <div className="col-md-6 mb-3">
            <label>Last Name</label>
            <input
              name="lastName"
              className="form-control"
              value={employee.lastName}
              onChange={handleChange}
              required
            />
          </div>
        </div>

        <div className="mb-3">
          <label>Email</label>
          <input
            name="email"
            className="form-control"
            value={employee.email}
            onChange={handleChange}
            required
          />
        </div>

        <div className="mb-3">
          <label>Phone</label>
          <input
            name="phone"
            className="form-control"
            value={employee.phone}
            onChange={handleChange}
            required
          />
        </div>

        <div className="row">
          <div className="col-md-6 mb-3">
            <label>Gender</label>
            <input
              name="gender"
              className="form-control"
              value={employee.gender}
              onChange={handleChange}
            />
          </div>

          <div className="col-md-6 mb-3">
            <label>Designation</label>
            <input
              name="designation"
              className="form-control"
              value={employee.designation}
              onChange={handleChange}
            />
          </div>
        </div>

        <div className="mb-3">
          <label>Status</label>
          <input
            name="status"
            className="form-control"
            value={employee.status}
            onChange={handleChange}
          />
        </div>

        <button className="btn btn-success me-2">Save Changes</button>
        <button
          type="button"
          className="btn btn-secondary"
          onClick={() => navigate("/employees")}
        >
          Cancel
        </button>
      </form>
    </div>
  );
}

export default EmployeeEdit;
