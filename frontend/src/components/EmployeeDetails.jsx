import React, { useEffect, useState } from "react";
import axios from "axios";
import { useParams, Link } from "react-router-dom";
import SecondaryInfoSection from "./SecondaryInfoSection";
import PermanentAddressSection from "./PermanentAddressSection";
import TemporaryAddressSection from "./TemporaryAddressSection";
import BankDetailsSection from "./BankDetailsSection";
import EducationSection from "./EducationSection";
import ExperienceSection from "./ExperienceSection";
import TechnicalSkillsSection from "./TechnicalSkillsSection";
import ContactInfoSection from "./ContactInfoSection";

function EmployeeDetails() {
  const { id } = useParams();
  const [employee, setEmployee] = useState(null);

  useEffect(() => {
    axios
      .get(`http://localhost:8080/api/employees/${id}`)
      .then((res) => setEmployee(res.data))
      .catch((err) => console.error(err));
  }, [id]);

  if (!employee) return <p>Loading...</p>;

  return (
    <div>
      <h3>Employee Details</h3>

      {/* PRIMARY INFO */}
      <div className="card p-3 mb-3">
        <h4>{employee.firstName} {employee.lastName}</h4>

        <p><strong>Email:</strong> {employee.email}</p>
        <p><strong>Phone:</strong> {employee.phone}</p>
        <p><strong>Gender:</strong> {employee.gender}</p>
        <p><strong>Designation:</strong> {employee.designation}</p>
        <p><strong>Status:</strong> {employee.status}</p>

        <Link
          to={`/employees/edit/${employee.employeeId}`}
          className="btn btn-primary mt-2"
        >
          Edit Primary Info
        </Link>
      </div>

      {/* SECTIONS */}
      <SecondaryInfoSection employeeId={id} />
      <PermanentAddressSection employeeId={id} />
      <TemporaryAddressSection employeeId={id} />
      <BankDetailsSection employeeId={id} />
      <EducationSection employeeId={id} />
      <ExperienceSection employeeId={id} />
      <TechnicalSkillsSection employeeId={id} />
      <ContactInfoSection employeeId={id} />

      <hr />
      <h5>🎉 All employee modules completed successfully!</h5>
    </div>
  );
}

export default EmployeeDetails;
