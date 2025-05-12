import React from 'react';
import BookCard from "../BookCard/BookCard.jsx";
import { Grid } from "@mui/material";

const BooksGrid = ({ books, onEdit, onDelete }) => {
    return (
        <Grid container spacing={{ xs: 2, md: 3 }}>
            {books.map((book, index) => {
                console.log("Rendering book:", book);
                return (
                    <Grid item key={book.id ?? index} xs={12} sm={6} md={4} lg={3}>
                        <BookCard
                            book={book}
                            onEdit={onEdit}
                            onDelete={onDelete}
                        />
                    </Grid>
                )}
            )};
        </Grid>
    );
};

export default BooksGrid;
