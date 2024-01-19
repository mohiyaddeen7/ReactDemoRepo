import React, { useEffect, useState } from "react";

export default function Form() {
  const [fullname, setFullName] = useState("");
  const [interest, setInterest] = useState("");
  const [users, setUsers] = useState({});

  const handleInterestChange = (e) => {
    setInterest(e.target.value);
  };
  const handleFullNameChange = (e) => {
    setFullName(e.target.value);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch("http://localhost:8080/addUser", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ fullName: fullname, interest }),
      });

      if (response.ok) {
        const result = await response.json();
        alert("User Has been Created");
      }
    } catch (error) {
      console.error(error);
    }
    setFullName("");
    setInterest("");
  };

  const getUsers = async () => {
    try {
      const response = await fetch("http://localhost:8080/getUsers");

      if (response.ok) {
        const result = await response.json();
        setUsers(result);
        console.log(result);
      }
    } catch (error) {
      console.error("Some Error");
    }
  };

  useEffect(() => {
    getUsers();
  }, []);

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <label htmlFor="fullName">Enter your Full name</label>
        <input
          type="text"
          name="fullName"
          id="fullName"
          value={fullname}
          onChange={handleFullNameChange}
        />
        <label htmlFor="fullName">Enter your interest</label>
        <input
          type="text"
          name="interest"
          id="interest"
          value={interest}
          onChange={handleInterestChange}
        />
        <button type="submit">Submit</button>
      </form>

      <div>
        <h2>Data</h2>
      </div>
    </div>
  );
}
