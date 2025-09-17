import React from "react";
import { Box, Typography, Container } from "@mui/material";

const Footer = () => {
    return (
        <Box
            component="footer"
            sx={{
                backgroundColor: "#4975CAFF",
                color: "#F0F0F0",
                py: 3,
                mt: "auto",
            }}
        >
            <Container maxWidth="lg" sx={{ textAlign: "center" }}>
                <Typography variant="body2">
                    © {new Date().getFullYear()} LibraryApp. All rights reserved.
                </Typography>
            </Container>
        </Box>
    );
};

export default Footer;
