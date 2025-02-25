import React, { useEffect, useState } from "react";
import { getAllEmployees, deleteEmployee } from "./EmployeeService";
import { useNavigate } from "react-router-dom";

const EmployeeList = () => {
    const [employees, setEmployees] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        loadEmployees();
    }, []);

    const loadEmployees = async () => {
        const response = await getAllEmployees();
        setEmployees(response.data);
    };

    const handleDelete = async (id) => {
        await deleteEmployee(id);
        loadEmployees();
    };

    return (
        <div>
            <h2>Employee List</h2>
            <button onClick={() => navigate("/add")}>Add Employee</button>
            <table border="1">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Phone</th>
                        <th>Email</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {employees.map((emp) => (
                        <tr key={emp.id}>
                            <td>{emp.name}</td>
                            <td>{emp.phone}</td>
                            <td>{emp.email}</td>
                            <td>
                                <button onClick={() => navigate(`/edit/${emp.id}`)}>Edit</button>
                                <button onClick={() => handleDelete(emp.id)}>Delete</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default EmployeeList;
