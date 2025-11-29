import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

function NavBar() {
  const [searchId, setSearchId] = useState("");
  const navigate = useNavigate();

  const handleSearch = (e) => {
    e.preventDefault();
    if (!searchId) return;

    navigate(`/employees/${searchId}/full-profile`);
    setSearchId("");
  };

  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-primary px-4">
      <Link className="navbar-brand fw-bold" to="/employees">
        WORKHUB – The Learning Management Platform
      </Link>

      <div className="collapse navbar-collapse">
        <ul className="navbar-nav ms-auto">

          <li className="nav-item">
            <Link className="nav-link" to="/employees">Employees</Link>
          </li>

          <li className="nav-item">
            <Link className="nav-link" to="/employees/add">Add Employee</Link>
          </li>

          {/* SEARCH BAR */}
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
