import React from "react";
import { BrowserRouter as Router, Routes, Route, useParams } from "react-router-dom";

import NavBar from "./components/NavBar";
import EmployeeList from "./components/EmployeeList";
import EmployeeAdd from "./components/EmployeeAdd";
import EmployeeDetails from "./components/EmployeeDetails";
import EmployeeEdit from "./components/EmployeeEdit";
import EmployeeFullProfile from "./components/EmployeeFullProfile";

// Wrapper so we can read :id from URL inside Full Profile
function FullProfileWrapper() {
  const { id } = useParams();
  return <EmployeeFullProfile employeeId={id} />;
}

function App() {
  return (
    <Router>
      <NavBar />

      <div className="container mt-4">
        <Routes>

          {/* Default route -> Employee List */}
          <Route path="/" element={<EmployeeList />} />

          {/* Employee pages */}
          <Route path="/employees" element={<EmployeeList />} />
          <Route path="/employees/add" element={<EmployeeAdd />} />
          <Route path="/employees/:id" element={<EmployeeDetails />} />
          <Route path="/employees/edit/:id" element={<EmployeeEdit />} />

          {/* FULL PROFILE ROUTE */}
          <Route path="/employees/:id/full-profile" element={<FullProfileWrapper />} />

          {/* Catch-all fallback */}
          <Route path="*" element={<EmployeeList />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
