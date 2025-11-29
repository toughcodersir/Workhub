import React from "react";
import {
  BrowserRouter as Router,
  Routes,
  Route,
  useParams,
  Navigate
} from "react-router-dom";

import NavBar from "./components/NavBar";

// EMPLOYEE COMPONENTS
import EmployeeList from "./components/EmployeeList";
import EmployeeAdd from "./components/EmployeeAdd";
import EmployeeDetails from "./components/EmployeeDetails";
import EmployeeEdit from "./components/EmployeeEdit";
import EmployeeFullProfile from "./components/EmployeeFullProfile";

// ADMIN COMPONENTS
import AdminLogin from "./admin/AdminLogin";
import AdminRegister from "./admin/AdminRegister";
import AdminDashboard from "./admin/AdminDashboard";
import AdminProtectedRoute from "./admin/AdminProtectedRoute";

// BATCH PAGES
import BatchList from "./admin/batches/BatchList";
import BatchAdd from "./admin/batches/BatchAdd";
import BatchEdit from "./admin/batches/BatchEdit";

// MENTOR PAGES
import MentorList from "./admin/mentors/MentorList";
import MentorAdd from "./admin/mentors/MentorAdd";
import MentorEdit from "./admin/mentors/MentorEdit";

// Wrapper to read :id param for full profile
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

          {/* DEFAULT → Employee List */}
          <Route path="/" element={<EmployeeList />} />

          {/* EMPLOYEE ROUTES */}
          <Route path="/employees" element={<EmployeeList />} />
          <Route path="/employees/add" element={<EmployeeAdd />} />
          <Route path="/employees/:id" element={<EmployeeDetails />} />
          <Route path="/employees/edit/:id" element={<EmployeeEdit />} />
          <Route path="/employees/:id/full-profile" element={<FullProfileWrapper />} />

          {/* ADMIN AUTH */}
          <Route path="/admin/login" element={<AdminLogin />} />
          <Route path="/admin/register" element={<AdminRegister />} />

          {/* ADMIN DASHBOARD (protected) */}
          <Route
            path="/admin"
            element={
              <AdminProtectedRoute>
                <AdminDashboard />
              </AdminProtectedRoute>
            }
          />

          {/* ADMIN BATCH ROUTES */}
          <Route
            path="/admin/batches"
            element={
              <AdminProtectedRoute>
                <BatchList />
              </AdminProtectedRoute>
            }
          />

          <Route
            path="/admin/batches/add"
            element={
              <AdminProtectedRoute>
                <BatchAdd />
              </AdminProtectedRoute>
            }
          />

          <Route
            path="/admin/batches/edit/:id"
            element={
              <AdminProtectedRoute>
                <BatchEdit />
              </AdminProtectedRoute>
            }
          />

          {/* ADMIN MENTOR ROUTES */}
          <Route
            path="/admin/mentors"
            element={
              <AdminProtectedRoute>
                <MentorList />
              </AdminProtectedRoute>
            }
          />

          <Route
            path="/admin/mentors/add"
            element={
              <AdminProtectedRoute>
                <MentorAdd />
              </AdminProtectedRoute>
            }
          />

          <Route
            path="/admin/mentors/edit/:id"
            element={
              <AdminProtectedRoute>
                <MentorEdit />
              </AdminProtectedRoute>
            }
          />

          {/* CATCH ALL */}
          <Route path="*" element={<Navigate to="/" />} />

        </Routes>
      </div>
    </Router>
  );
}

export default App;
