import React from "react";
import { Link } from "react-router-dom";

const AdminDashboard = () => {
  return (
    <div className="page-container">
      <h2>Admin Dashboard</h2>

      <div className="list-group mt-4">
        <Link className="list-group-item list-group-item-action" to="/admin/batches">
          Manage Batches
        </Link>

        <Link className="list-group-item list-group-item-action" to="/admin/mentors">
          Manage Mentors
        </Link>

        <Link className="list-group-item list-group-item-action" to="/employees">
          Employees
        </Link>
      </div>
    </div>
  );
};

export default AdminDashboard;
