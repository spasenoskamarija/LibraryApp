import React from 'react';
import {Box, Container} from "@mui/material";
import Header from "../Layout/Header/Header.jsx"
import {Outlet} from "react-router";
import "./Layout.css";
import Footer from "./Footer/Footer.jsx";

const Layout = () => {
    return (
        <Box
            sx={{
                display: "flex",
                flexDirection: "column",
                minHeight: "100vh",
            }}
        >
            <Header />
            <Box component="main" sx={{ flexGrow: 1, p: 3 }}>
                <Outlet />
            </Box>
            <Footer />
        </Box>
    );
};


export default Layout;
