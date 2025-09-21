document.addEventListener("DOMContentLoaded", function() {

    // --- SLIDESHOW LOGIC ---
    let slideIndex = 0;
    showSlides();

    function showSlides() {
        let slides = document.getElementsByClassName("slide");
        // Hide all slides
        for (let i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }
        // Increment index
        slideIndex++;
        // Reset index to 1 if it goes beyond the number of slides
        if (slideIndex > slides.length) {
            slideIndex = 1;
        }
        // Display the current slide
        slides[slideIndex - 1].style.display = "block";
        // Call the function again after 4 seconds (4000 milliseconds)
        setTimeout(showSlides, 4000);
    }


    // --- EVENT FILTERING LOGIC ---
    const filters = document.querySelectorAll('.event-filter');

    filters.forEach(filter => {
        filter.addEventListener('change', function() {
            const selectedCategory = this.value;
            // Find the parent calendar-day element to get the right event list
            const eventList = this.closest('.calendar-day').querySelector('.event-list');
            const events = eventList.querySelectorAll('.event-item');

            events.forEach(event => {
                // Check if the event's class list contains the selected category, or if 'all' is selected
                if (selectedCategory === 'all' || event.classList.contains(selectedCategory)) {
                    event.style.display = 'block'; // Show the event
                } else {
                    event.style.display = 'none'; // Hide the event
                }
            });
        });
    });


    // --- "ADD EVENT" BUTTON ---
    // This is a placeholder. A real implementation would open a form or a new page.
    const addEventButton = document.querySelector('.add-event-btn');
    if(addEventButton) {
        addEventButton.addEventListener('click', function() {
            alert('This would open a form to add a new event!');
        });
    }

});