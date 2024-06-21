Problem Statement: Modeling a Ticketing System Using a Queue

Design and implement a ticketing system using a queue data structure. The system should be able to issue tickets to customers and process these tickets in the order they were issued (FIFO - First In, First Out). The implementation should support the following operations:

Issue a Ticket:

Assign a unique ticket ID to each new ticket.
Associate each ticket with a customer's name.
Add the new ticket to the queue.
Process a Ticket:

Retrieve and remove the ticket at the front of the queue.
Display the ticket details (ticket ID and customer name) of the processed ticket.
Handle the case where there are no tickets to process.
View Next Ticket:

Display the ticket details of the next ticket to be processed without removing it from the queue.
Handle the case where there are no tickets in the queue.
The system should ensure that tickets are processed in the order they are issued and provide appropriate feedback when operations are performed.
