import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

function EmployeeList() {
  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/api/employees")
      .then(res => setEmployees(res.data))
      .catch(err => console.error(err));
  }, []);

  const handleDelete = (id) => {
    if (!window.confirm("Are you sure you want to delete this employee?")) return;

    axios.delete(`http://localhost:8080/api/employees/${id}`)
      .then(() => {
        setEmployees(prev => prev.filter(e => e.employeeId !== id));
      })
      .catch(err => {
        console.error(err);
        alert("Failed to delete");
      });
  };

  return (
    <div>
      <div className="d-flex justify-content-between align-items-center mb-3">
        <h2>Employees</h2>
        <Link to="/employees/add" className="btn btn-primary">+ Add Employee</Link>
      </div>

      <table className="table table-bordered table-hover">
        <thead className="table-dark">
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th style={{ width: "220px" }}>Actions</th>
          </tr>
        </thead>

        <tbody>
          {employees.map(emp => (
            <tr key={emp.employeeId}>
              <td>{emp.employeeId}</td>
              <td>{emp.firstName} {emp.lastName}</td>
              <td>{emp.email}</td>
              <td>{emp.phone}</td>
              <td>
                <Link
                  to={`/employees/${emp.employeeId}`}
                  className="btn btn-sm btn-info me-2"
                >
                  View
                </Link>

                <Link
                  to={`/employees/edit/${emp.employeeId}`}
                  className="btn btn-sm btn-warning me-2"
                >
                  Edit
                </Link>

                <button
                  className="btn btn-sm btn-danger"
                  onClick={() => handleDelete(emp.employeeId)}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>

      </table>
    </div>
  );
}

export default EmployeeList;
