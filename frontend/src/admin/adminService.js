import axios from "axios";

const API = "http://localhost:8080/api";  // Base backend URL

// ===================================================================
// ADMIN AUTH
// ===================================================================

export const adminRegister = (payload) =>
  axios.post(`${API}/admin/register`, payload);

export const adminLogin = (payload) =>
  axios.post(`${API}/admin/login`, payload);

// ===================================================================
// BATCH MANAGEMENT
// ===================================================================

export const createBatch = (payload) =>
  axios.post(`${API}/admin/batches`, payload);

export const updateBatch = (id, payload) =>
  axios.put(`${API}/admin/batches/${id}`, payload);

export const deleteBatch = (id) =>
  axios.delete(`${API}/admin/batches/${id}`);

export const getBatchById = (id) =>
  axios.get(`${API}/admin/batches/${id}`);

// ⭐ FIX: no /api/admin/batches GET, so use search endpoint
export const getAllBatches = () =>
  axios.get(`${API}/admin/batches/search?keyword=`);

export const searchBatches = (keyword) =>
  axios.get(`${API}/admin/batches/search?keyword=${keyword}`);

// ===================================================================
// MENTOR MANAGEMENT
// ===================================================================

export const createMentor = (payload) =>
  axios.post(`${API}/admin/mentors`, payload);

export const updateMentor = (id, payload) =>
  axios.put(`${API}/admin/mentors/${id}`, payload);

export const deleteMentor = (id) =>
  axios.delete(`${API}/admin/mentors/${id}`);

export const getMentorById = (id) =>
  axios.get(`${API}/admin/mentors/${id}`);

// ⭐ FIX: no /api/admin/mentors GET, so use search endpoint
export const getAllMentors = () =>
  axios.get(`${API}/admin/mentors/search?keyword=`);

export const searchMentors = (keyword) =>
  axios.get(`${API}/admin/mentors/search?keyword=${keyword}`);
