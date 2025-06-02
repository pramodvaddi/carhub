const BASE_URL = "http://localhost:8080/api";

document.addEventListener("DOMContentLoaded", () => {
  const form = document.getElementById("carForm");

  form.addEventListener("submit", async (e) => {
    e.preventDefault();

    const make = document.getElementById("make").value;
    const model = document.getElementById("model").value;
    const year = document.getElementById("year").value;

    const car = { make, model, year };

    try {
      const response = await fetch(`${BASE_URL}/cars`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(car),
      });

      const data = await response.json();
      console.log("Response:", response.status, data);

      if (response.ok) {
        alert("Car added successfully!");
        fetchCars(); // refresh list
        form.reset();
      } else {
        alert("Error adding car: " + data.message);
      }
    } catch (error) {
      alert("Network error: " + error.message);
      console.error(error);
    }
  });

  // Fetch and display all cars
  async function fetchCars() {
    const carListElement = document.getElementById("carList");
    if (!carListElement) {
      console.error("Element with ID 'carList' not found.");
      return;
    }

    try {
      const response = await fetch(`${BASE_URL}/cars`);
      const cars = await response.json();

      carListElement.innerHTML = "";
      cars.forEach((car) => {
        const item = document.createElement("li");
        item.className = "list-group-item d-flex justify-content-between align-items-center";
        item.innerHTML = `
          <span>${car.make} ${car.model} (${car.year})</span>
          <button class="btn btn-sm btn-danger" onclick="deleteCar(${car.id})">Delete</button>
        `;
        carListElement.appendChild(item);
      });
    } catch (error) {
      console.error("Failed to fetch cars:", error);
    }
  }

  // Delete a car by ID
  window.deleteCar = async function (id) {
    const confirmed = confirm("Are you sure you want to delete this car?");
    if (!confirmed) return;

    try {
      const response = await fetch(`${BASE_URL}/cars/${id}`, {
        method: "DELETE",
      });

      if (response.status === 204) {
        alert("Car deleted successfully!");
        fetchCars(); // Refresh list
      } else {
        alert("Error deleting car.");
      }
    } catch (error) {
      alert("Network error while deleting: " + error.message);
      console.error(error);
    }
  };

  fetchCars(); // initial load
});
