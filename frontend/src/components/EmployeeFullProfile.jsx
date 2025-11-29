import React, { useEffect, useState } from "react";
import axios from "axios";

function EmployeeFullProfile({ employeeId }) {
  const [primary, setPrimary] = useState(null);
  const [secondary, setSecondary] = useState(null);
  const [permanent, setPermanent] = useState(null);
  const [temporary, setTemporary] = useState(null);
  const [bank, setBank] = useState(null);
  const [contacts, setContacts] = useState([]);
  const [education, setEducation] = useState([]);
  const [experience, setExperience] = useState([]);
  const [skills, setSkills] = useState([]);

  const [loading, setLoading] = useState(true);

  useEffect(() => {
    async function fetchAll() {
      try {
        const p = await axios.get(`http://localhost:8080/api/employees/${employeeId}`);
        const s = await axios.get(`http://localhost:8080/api/employees/${employeeId}/secondary`);
        const pa = await axios.get(`http://localhost:8080/api/employees/${employeeId}/permanent-address`);
        const ta = await axios.get(`http://localhost:8080/api/employees/${employeeId}/temporary-address`);
        const b = await axios.get(`http://localhost:8080/api/bank/${employeeId}`);
        const c = await axios.get(`http://localhost:8080/api/contact/${employeeId}`);
        const ed = await axios.get(`http://localhost:8080/api/education/employee/${employeeId}`);
        const ex = await axios.get(`http://localhost:8080/api/experience/employee/${employeeId}`);
        const sk = await axios.get(`http://localhost:8080/api/skills/${employeeId}`);

        setPrimary(p.data);
        setSecondary(s.data);
        setPermanent(pa.data);
        setTemporary(ta.data);
        setBank(b.data);
        setContacts(c.data);
        setEducation(ed.data);
        setExperience(ex.data);
        setSkills(sk.data);
      } catch (err) {
        console.error("Error loading full profile");
      } finally {
        setLoading(false);
      }
    }

    fetchAll();
  }, [employeeId]);

  if (loading) return <h3 className="text-center mt-4">Loading Profile...</h3>;

  return (
    <div className="container mt-4">

      <h2 className="text-center mb-4">Full Employee Profile</h2>

      {/* Primary Info */}
      <div className="card p-3 mb-3">
        <h4>Primary Information</h4>
        <pre>{JSON.stringify(primary, null, 2)}</pre>
      </div>

      {/* Secondary Info */}
      <div className="card p-3 mb-3">
        <h4>Secondary Information</h4>
        <pre>{JSON.stringify(secondary, null, 2)}</pre>
      </div>

      {/* Addresses */}
      <div className="card p-3 mb-3">
        <h4>Permanent Address</h4>
        <pre>{JSON.stringify(permanent, null, 2)}</pre>

        <h4 className="mt-3">Temporary Address</h4>
        <pre>{JSON.stringify(temporary, null, 2)}</pre>
      </div>

      {/* Bank */}
      <div className="card p-3 mb-3">
        <h4>Bank Details</h4>
        <pre>{JSON.stringify(bank, null, 2)}</pre>
      </div>

      {/* Contacts */}
      <div className="card p-3 mb-3">
        <h4>Contact Info</h4>
        <pre>{JSON.stringify(contacts, null, 2)}</pre>
      </div>

      {/* Education */}
      <div className="card p-3 mb-3">
        <h4>Education</h4>
        <pre>{JSON.stringify(education, null, 2)}</pre>
      </div>

      {/* Experience */}
      <div className="card p-3 mb-3">
        <h4>Experience</h4>
        <pre>{JSON.stringify(experience, null, 2)}</pre>
      </div>

      {/* Skills */}
      <div className="card p-3 mb-3">
        <h4>Technical Skills</h4>
        <pre>{JSON.stringify(skills, null, 2)}</pre>
      </div>

    </div>
  );
}

export default EmployeeFullProfile;
