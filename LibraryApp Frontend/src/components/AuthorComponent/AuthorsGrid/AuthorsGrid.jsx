import React from 'react';
import AuthorCard from "../AuthorCard/AuthorCard.jsx";
import { Grid } from "@mui/material";

const AuthorsGrid = ({ authors,onEdit, onDelete }) => {
    return (
        <Grid container spacing={{ xs: 2, md: 3 }}>
            {authors.map((author, index) => (
                <Grid item key={index} xs={12} sm={6} md={4} lg={3}>
                    <AuthorCard author={author}
                                onEdit={onEdit}
                                onDelete={onDelete}/>
                </Grid>
            ))}
        </Grid>
    );
};

export default AuthorsGrid;

