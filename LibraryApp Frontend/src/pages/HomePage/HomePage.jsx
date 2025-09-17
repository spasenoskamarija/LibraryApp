import React from 'react';
import { Box, Typography, Button } from "@mui/material";
import BookIcon from '@mui/icons-material/Book';

const HomePage = () => {
    return (
        <Box
            sx={{
                minHeight: "100vh",
                display: "flex",
                flexDirection: "column",
                justifyContent: "center",
                alignItems: "center",
                background: "#f5f5f5",
                padding: "2rem",
            }}
        >

            <Typography variant="h2" gutterBottom color="primary">
                Welcome to LibraryApp 📚
            </Typography>

            <img
                src="https://plus.unsplash.com/premium_photo-1676575893806-985f71a3ebd7?q=80&w=3116&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                alt="Stack of books"
                style={{
                    width: "500px",
                    maxWidth: "90%",
                    marginBottom: "2rem",
                    borderRadius: "16px",
                    boxShadow: "0 6px 20px rgba(0, 0, 0, 0.1)",
                }}
            />

            <Typography variant="h6" sx={{mb: 4, color: "#555", textAlign: "center", maxWidth: "600px"}}>
                Enjoy your favorite books all in one place.
            </Typography>
        </Box>
    );
};

export default HomePage;
