import React, { useState } from "react";
import {
    Box,
    CircularProgress,
    Typography,
    Grid,
    AppBar,
    Toolbar,
    Button,
} from "@mui/material";
import useBooks from "../../hooks/useBooks.js";
import AddBookDialog from "../../components/BookComponent/AddBookDialog/AddBookDialog.jsx";
import BookCard from "../../components/BookComponent/BookCard/BookCard.jsx";
import "./BooksPage.css";
import BookInfoDialog from "../../components/BookComponent/BookInfoDialog/BookInfo.jsx";
import useWishlist from "../../hooks/useWishlist.js";

const BooksPage = () => {
    const { books, loading, onDelete, onEdit, onAdd } = useBooks();
    const [addBookDialog, setAddBookDialog] = useState(false);
    const [selectedBook, setSelectedBook] = useState(null);
    const { addToWishlist } = useWishlist("marija")
    return (
        <>
            {/* Top bar */}
            <AppBar position="static" color="default" elevation={1}>
                <Toolbar sx={{ display: "flex", justifyContent: "flex-end" }}>
                    <Button
                        variant="contained"
                        color="primary"
                        onClick={() => setAddBookDialog(true)}
                    >
                        Add Book
                    </Button>
                </Toolbar>
            </AppBar>

            <Box sx={{ p: 4 }}>
                {loading && (
                    <Box className="progress-box">
                        <CircularProgress />
                    </Box>
                )}

                {!loading && (
                    <>
                        <Typography variant="h5" sx={{ mb: 2, fontWeight: "bold" }}>
                            My Books
                        </Typography>
                        <Grid container spacing={3} sx={{ mb: 4 }}>
                            {books.map((book) => (
                                <Grid item xs={12} sm={6} md={4} lg={2} key={book.id}>
                                    <BookCard
                                        book={book}
                                        onEdit={onEdit}
                                        onDelete={onDelete}
                                        onInfo={() => setSelectedBook(book)}
                                        addToWishlist={addToWishlist}
                                    />
                                </Grid>
                            ))}
                        </Grid>
                    </>
                )}
            </Box>

            {/* Add Book Dialog */}
            <AddBookDialog
                open={addBookDialog}
                onClose={() => setAddBookDialog(false)}
                onAdd={onAdd}
            />

            {/* Book Info Dialog */}
            {selectedBook && (
                <BookInfoDialog
                    book={selectedBook}
                    open={!!selectedBook}
                    onClose={() => setSelectedBook(null)}
                />
            )}
        </>
    );
};

export default BooksPage;
