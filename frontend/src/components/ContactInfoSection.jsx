import React, { useEffect, useState } from "react";
import axios from "axios";

function ContactInfoSection({ employeeId }) {
  const [contacts, setContacts] = useState([]);

  const [form, setForm] = useState({
    phoneType: "",
    phoneNumber: "",
    emailType: "",
    email: "",
  });

  const [loading, setLoading] = useState(true);

  // Fetch existing contacts
  useEffect(() => {
    axios
      .get(`http://localhost:8080/api/contact/${employeeId}`)
      .then((res) => setContacts(res.data))
      .catch(() => {})
      .finally(() => setLoading(false));
  }, [employeeId]);

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleAdd = (e) => {
    e.preventDefault();

    axios
      .post(`http://localhost:8080/api/contact/${employeeId}`, form)
      .then((res) => {
        setContacts([...contacts, res.data]);
        setForm({
          phoneType: "",
          phoneNumber: "",
          emailType: "",
          email: "",
        });
      })
      .catch(() => alert("Failed to add contact"));
  };

  const handleDelete = (contactId) => {
    if (!window.confirm("Delete this contact?")) return;

    axios
      .delete(`http://localhost:8080/api/contact/${contactId}`)
      .then(() => {
        setContacts(contacts.filter((c) => c.contactId !== contactId));
      })
      .catch(() => alert("Failed to delete contact"));
  };

  if (loading) return <p>Loading Contact Info...</p>;

  return (
    <div className="card p-3 mb-4">
      <h5>Contact Information</h5>

      {/* Add Contact Form */}
      <form onSubmit={handleAdd} className="mb-3">
        <div className="row">
          <div className="col-md-6">
            <label>Phone Type</label>
            <select
              name="phoneType"
              className="form-control"
              value={form.phoneType}
              onChange={handleChange}
              required
            >
              <option value="">Select</option>
              <option value="Home">Home</option>
              <option value="Work">Work</option>
              <option value="Mobile">Mobile</option>
            </select>
          </div>

          <div className="col-md-6">
            <label>Phone Number</label>
            <input
              name="phoneNumber"
              className="form-control"
              value={form.phoneNumber}
              onChange={handleChange}
              required
            />
          </div>
        </div>

        <div className="row mt-2">
          <div className="col-md-6">
            <label>Email Type</label>
            <select
              name="emailType"
              className="form-control"
              value={form.emailType}
              onChange={handleChange}
              required
            >
              <option value="">Select</option>
              <option value="Personal">Personal</option>
              <option value="Work">Work</option>
            </select>
          </div>

          <div className="col-md-6">
            <label>Email</label>
            <input
              name="email"
              className="form-control"
              value={form.email}
              onChange={handleChange}
              required
            />
          </div>
        </div>

        <button className="btn btn-success mt-3">Add Contact</button>
      </form>

      {/* Display Table */}
      <table className="table table-bordered">
        <thead className="table-dark">
          <tr>
            <th>Phone Type</th>
            <th>Phone Number</th>
            <th>Email Type</th>
            <th>Email</th>
            <th>Actions</th>
          </tr>
        </thead>

        <tbody>
          {contacts.length === 0 && (
            <tr>
              <td colSpan="5" className="text-center text-muted">
                No contact info added yet.
              </td>
            </tr>
          )}

          {contacts.map((c) => (
            <tr key={c.contactId}>
              <td>{c.phoneType}</td>
              <td>{c.phoneNumber}</td>
              <td>{c.emailType}</td>
              <td>{c.email}</td>
              <td>
                <button
                  className="btn btn-sm btn-danger"
                  onClick={() => handleDelete(c.contactId)}
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

export default ContactInfoSection;
