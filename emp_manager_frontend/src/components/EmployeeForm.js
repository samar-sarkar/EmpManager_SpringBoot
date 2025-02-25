import React, { useState, useEffect } from "react";
import { createEmployee, updateEmployee, getEmployeeById } from "./EmployeeService";
import { useNavigate, useParams } from "react-router-dom";

const EmployeeForm = () => {
    const [employee, setEmployee] = useState({ name: "", phone: "", email: "" });
    const navigate = useNavigate();
    const { id } = useParams();

    useEffect(() => {
        if (id) {
            getEmployeeById(id).then((res) => setEmployee(res.data));
        }
    }, [id]);

    const handleChange = (e) => {
        setEmployee({ ...employee, [e.target.name]: e.target.value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        if (id) {
            await updateEmployee(id, employee);
        } else {
            await createEmployee(employee);
        }
        navigate("/");
    };

    return (
        <div>
            <h2>{id ? "Edit Employee" : "Add Employee"}</h2>
            <form onSubmit={handleSubmit}>
                <input type="text" name="name" placeholder="Name" value={employee.name} onChange={handleChange} required />
                <input type="text" name="phone" placeholder="Phone" value={employee.phone} onChange={handleChange} required />
                <input type="email" name="email" placeholder="Email" value={employee.email} onChange={handleChange} required />
                <button type="submit">{id ? "Update" : "Save"}</button>
                <button onClick={() => navigate("/")}>Cancel</button>
            </form>
        </div>
    );
};

export default EmployeeForm;
