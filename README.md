# TicketBookingSystem


A simple flow using the first diagram.
1. The user sends request to book a ticket for a PVR movie to our app server.
2. Our app server calls the apis of PVR cinemas and requests them to reserve the tickets. This is done so that this seat is 	locked for the user for say 10 minutes and no other user can reserve it.
3. Our app server gets a success response from the PVR cinemas and it redirects the user to the payment page.
4. The user makes the payment with the help of the app server.
5. Our app server notifies to the PVR cinemas that payment is made.
6. The PVR cinemas marks the seat as booked and returns a success response to our app server.
7. Our app server notifies the user that the booking is confirmed.
8. In case the payment is made and before our app server notifies the PVR cinemas the 10 minute window expires and someone 	else reserves the seat then we will inform this to our user and refund the amount.