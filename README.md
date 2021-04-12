# Among SMS
A2P location sharing Android application for HackTJ 8.0.

## Rationale
Location sharing is an incredibly useful product of the digital age. Wheter meeting up with friends, staying safe after dark, or thousands of other uses, it has changed the way we plan our lives and use the technology around us. However, there are some people that don't trust the main players like Facebook, Apple, and Google with their location data, and that's perfectly valid. Location is a highly sensitive and personal piece of information to give to an enourmous company.  

## Overview
Among SMS is a proof-of-concept location sharing service that works entirely independent of the internet. By creating an SMS receiver app that will read texts from a specified friend's phone number __*without looking at previous chat history or messages into the future*__, location data can be sent and received securely, entirely independent of the internet.

## Inspiration
We use services like Find My. Yet, with recent exploits on companies as large as Facebook on the scale of billions of users, we realize that these services are by nature susceptible to exploitation. The business models and natures of large corporations that profit off of user data and constitute some of the biggest targets for exploitation outside government entities make the security of server data a serious concern.

## What it does
Among SMS allows users to share their locations with peace of mind. Our app utilizes state of the art application-to-peer messaging technology to bypass the potentially sus central authority. As a result, Among SMS is highly applicable to sensitive applications including to:
- Avoid data mining by monolithic corporations
- Share locations of minors without fear of interception
- Coordinate protests and keep demonstrations safe

## How we built it
We directly send location data from phone to phone in an encrypted manner on any network worldwide. We harness application-to-peer technology which has specific characteristics which are crucial to our mission as outlined below with many security measures at your fingertips to keep your account safe within a decentralized network that derives trust from you, the user.

### Architecture
Designed around the notion of equal peer nodes connected by the application that are both the "client" and the "server" as they send and receive location data.

### Routing and Trust
Since each user is a node interfacing with other people whom they trust, there is no need for users to trust the network itself, rather our app is the vector through which users trust one another

### Distributed Storage
No location data is ever stored anywhere other than the two peer nodes in a transaction of information. The application simply assists nodes in exchanging this information, and the info is stored totally offline and locally.

## Challenges we ran into
Challenges we encountered include figuring out how to handle SMS, incorporating Google Maps, and accessing location data. Specifically, we spent considerable time accessing and correctly implementing Google Maps protection and keys.

## Accomplishments that we're proud of
- Location display on an accurate and interactive map
- Receives and handles SMS in background; AMONG SMS does not need to be open to receive incoming SMS location updates
- Respectfully accessing and storing location data in SMS messages
- Uses custom art and banners
- Provides alternative for competing location service providers
    - Bypasses the internet

## What we learned
- Implementing Google Maps API
- Proper use of fragments (particularly with Google Maps)
- SMS handling and sending
- Time management
- Version control

## What's next for AMONG SMS
- Improving location retrieval
- Contacts list to send/receive location from
- World domination
- More map features
