import React from 'react';
import { Link } from "react-router-dom";
import { AppBar, Box, Button, IconButton, Toolbar, Typography } from "@mui/material";
import MenuIcon from '@mui/icons-material/Menu';

const pages = [
    { path: "/", name: "Home" },
    { path: "/books", name: "Books" },
    { path: "/authors", name: "Authors" },
    { path: "/countries", name: "Countries" },
];

const Header = () => {
    return (
        <AppBar position="static" >
            <Toolbar sx={{ justifyContent: "space-between" }}>
                {/* Logo and title */}
                <Box sx={{ display: "flex", alignItems: "center" }}>
                    <IconButton size="large" edge="start" color="inherit" sx={{ mr: 2 }}>
                        <MenuIcon />
                    </IconButton>
                    <Typography variant="h5" sx={{ fontWeight: "bold" }}>
                        LibraryApp
                    </Typography>
                </Box>

                {/* Navigation links */}
                <Box sx={{ display: "flex", gap: 2 }}>
                    {pages.map((page) => (
                        <Button
                            key={page.name}
                            component={Link}
                            to={page.path}
                            sx={{
                                color: "white",
                                textTransform: "capitalize",
                                fontSize: "1.1rem",
                                "&:hover": {
                                    backgroundColor: "#152c9e",
                                    color: "#fff"
                                }
                            }}
                        >
                            {page.name}
                        </Button>
                    ))}
                </Box>

                {/* Login */}
                <Button
                    variant="outlined"
                    color="inherit"
                    sx={{
                        borderColor: "#F0F0F0",
                        color: "#F0F0F0",
                        "&:hover": {
                            backgroundColor: "#B38B59",
                            borderColor: "#B38B59"
                        }
                    }}
                >
                    Login
                </Button>
            </Toolbar>
        </AppBar>
    );
};

export default Header;
