import React, { useEffect, useState } from "react";
import axios from "axios";

function TechnicalSkillsSection({ employeeId }) {
  const [skills, setSkills] = useState([]);

  const [form, setForm] = useState({
    skillName: "",
    proficiencyLevel: "",
  });

  useEffect(() => {
    axios
      .get(`http://localhost:8080/api/skills/${employeeId}`)
      .then((res) => setSkills(res.data))
      .catch(() => {});
  }, [employeeId]);

  const handleChange = (e) => setForm({ ...form, [e.target.name]: e.target.value });

  const handleAdd = (e) => {
    e.preventDefault();

    axios
      .post(`http://localhost:8080/api/skills/${employeeId}`, form)
      .then((res) => {
        setSkills([...skills, res.data]);
        setForm({ skillName: "", proficiencyLevel: "" });
      })
      .catch(() => alert("Failed to add skill"));
  };

  const handleDelete = (id) => {
    axios
      .delete(`http://localhost:8080/api/skills/${id}`)
      .then(() => setSkills(skills.filter((s) => s.skillId !== id)))
      .catch(() => alert("Failed to delete skill"));
  };

  return (
    <div className="card p-3 mb-3">
      <h5>Technical Skills</h5>

      <form onSubmit={handleAdd} className="mb-3">
        <label>Skill Name</label>
        <input className="form-control" name="skillName" value={form.skillName} onChange={handleChange} required />

        <label className="mt-2">Proficiency Level</label>
        <select className="form-control" name="proficiencyLevel" value={form.proficiencyLevel} onChange={handleChange} required>
          <option value="">Select</option>
          <option value="Beginner">Beginner</option>
          <option value="Intermediate">Intermediate</option>
          <option value="Expert">Expert</option>
        </select>

        <button className="btn btn-success mt-3">Add Skill</button>
      </form>

      <table className="table table-bordered">
        <thead className="table-dark">
          <tr>
            <th>Skill</th>
            <th>Proficiency</th>
            <th>Actions</th>
          </tr>
        </thead>

        <tbody>
          {skills.map((s) => (
            <tr key={s.skillId}>
              <td>{s.skillName}</td>
              <td>{s.proficiencyLevel}</td>
              <td>
                <button className="btn btn-danger btn-sm" onClick={() => handleDelete(s.skillId)}>
                  Delete
                </button>
              </td>
            </tr>
          ))}

          {skills.length === 0 && (
            <tr><td colSpan="3" className="text-center">No skills added.</td></tr>
          )}
        </tbody>
      </table>
    </div>
  );
}

export default TechnicalSkillsSection;
