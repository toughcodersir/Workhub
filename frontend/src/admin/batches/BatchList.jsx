import React, { useEffect, useState } from "react";
import { getAllBatches, deleteBatch } from "../adminService";
import { Link } from "react-router-dom";

const BatchList = () => {
  const [batches, setBatches] = useState([]);

  useEffect(() => {
    fetchBatches();
  }, []);

  const fetchBatches = async () => {
    try {
      const res = await getAllBatches();
      setBatches(res.data);
    } catch (err) {
      console.error(err);
    }
  };

  const handleDelete = async (id) => {
    if (!window.confirm("Delete this batch?")) return;
    try {
      await deleteBatch(id);
      fetchBatches();
    } catch (err) {
      console.error(err);
      alert("Delete failed");
    }
  };

  return (
    <div className="page-container">
      <div className="list-header">
        <h2>Batches</h2>
        <Link to="/admin/batches/add" className="btn">Add Batch</Link>
      </div>

      <table className="table">
        <thead>
          <tr>
            <th>Batch ID</th>
            <th>Name</th>
            <th>Technologies</th>
            <th>Start</th>
            <th>End</th>
            <th>Status</th>
            <th>Actions</th>
          </tr>
        </thead>

        <tbody>
          {batches.map(batch => (
            <tr key={batch.batchId}>
              <td>{batch.batchId}</td>
              <td>{batch.batchName}</td>
              <td>{batch.technologies}</td>
              <td>{batch.startDate}</td>
              <td>{batch.endDate}</td>
              <td>{batch.status}</td>

              <td>
                <Link
                  to={`/admin/batches/edit/${batch.batchId}`}
                  className="btn-small"
                >
                  Edit
                </Link>

                <button
                  onClick={() => handleDelete(batch.batchId)}
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

export default BatchList;
