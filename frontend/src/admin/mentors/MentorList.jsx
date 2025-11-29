import React, { useEffect, useState } from "react";
import { getAllMentors, deleteMentor } from "../adminService";
import { Link } from "react-router-dom";

const MentorList = () => {
  const [mentors, setMentors] = useState([]);

  useEffect(() => {
    fetchMentors();
  }, []);

  const fetchMentors = async () => {
    try {
      const res = await getAllMentors();
      setMentors(res.data);
    } catch (err) {
      console.error("Failed to load mentors:", err);
    }
  };

  const handleDelete = async (id) => {
    if (!window.confirm("Delete this mentor?")) return;

    try {
      await deleteMentor(id);
      fetchMentors();
    } catch (err) {
      console.error("Delete failed:", err);
      alert("Delete failed");
    }
  };

  return (
    <div className="page-container">
      <div className="list-header">
        <h2>Mentors</h2>
        <Link to="/admin/mentors/add" className="btn">Add Mentor</Link>
      </div>

      <table className="table">
        <thead>
          <tr>
            <th>Mentor ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Expertise</th>
            <th>Experience</th>
            <th>Actions</th>
          </tr>
        </thead>

        <tbody>
          {mentors.map((m) => (
            <tr key={m.mentorId}>
              <td>{m.mentorId}</td>
              <td>{m.name}</td>
              <td>{m.email}</td>
              <td>{m.phone}</td>
              <td>{m.expertise}</td>
              <td>{m.experience}</td>

              <td>
                <Link
                  to={`/admin/mentors/edit/${m.mentorId}`}
                  className="btn-small"
                >
                  Edit
                </Link>

                <button
                  onClick={() => handleDelete(m.mentorId)}
                  className="btn-small danger"
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
};

export default MentorList;
