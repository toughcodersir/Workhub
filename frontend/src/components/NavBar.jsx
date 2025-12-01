import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

function NavBar() {
  const [searchId, setSearchId] = useState("");
  const navigate = useNavigate();

  const isAdminLoggedIn = !!localStorage.getItem("admin");

  const handleSearch = (e) => {
    e.preventDefault();
    if (!searchId) return;

    navigate(`/employees/${searchId}/full-profile`);
    setSearchId("");
  };

  const handleAdminLogout = () => {
    localStorage.removeItem("admin");
    navigate("/admin/login");
  };

  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-primary px-4">
      <Link className="navbar-brand fw-bold" to="/employees">
        WORKHUB – The Learning Management Platform
      </Link>

      <div className="collapse navbar-collapse">
        <ul className="navbar-nav ms-auto">

          {/* Always visible */}
          <li className="nav-item">
            <Link className="nav-link" to="/employees">Employees</Link>
          </li>
          <li className="nav-item">
            <Link className="nav-link" to="/employees/add">Add Employee</Link>
          </li>

          {/* WHEN ADMIN IS NOT LOGGED IN */}
          {!isAdminLoggedIn && (
            <>
              <li className="nav-item">
                <Link className="nav-link" to="/admin/login">Admin Login</Link>
              </li>

              <li className="nav-item">
                <Link className="nav-link" to="/admin/register">Admin Register</Link>
              </li>
            </>
          )}

          {/* WHEN ADMIN IS LOGGED IN */}
          {isAdminLoggedIn && (
            <>
              <li className="nav-item">
                <Link className="nav-link" to="/admin">Dashboard</Link>
              </li>

              <li className="nav-item">
                <Link className="nav-link" to="/admin/batches">Batches</Link>
              </li>

              <li className="nav-item">
                <Link className="nav-link" to="/admin/mentors">Mentors</Link>
              </li>

              <li className="nav-item">
                <button
                  className="btn btn-warning ms-3"
                  onClick={handleAdminLogout}
                >
                  Logout
                </button>
              </li>
            </>
          )}

          {/* SEARCH BAR (open to everyone) */}
          <li className="nav-item ms-3">
            <form className="d-flex" onSubmit={handleSearch}>
              <input
                type="number"
                className="form-control"
                placeholder="Search ID..."
                value={searchId}
                onChange={(e) => setSearchId(e.target.value)}
                style={{ width: "140px" }}
              />
              <button className="btn btn-light ms-2">Go</button>
            </form>
          </li>

        </ul>
      </div>
    </nav>
  );
}

export default NavBar;
