import React from "react";
import { Grid, Typography, CircularProgress, Button } from "@mui/material";
import BookCard from "../../components/BookComponent/BookCard/BookCard.jsx";
import useWishlist from "../../hooks/useWishlist.js"

export default function WishlistPage({ username }) {
    const { wishlist, loading, rentAll, clearWishlist } = useWishlist(username);

    if (loading) return <CircularProgress />;

    return (
        <div>
            <Typography variant="h5" gutterBottom>
                My Wishlist
            </Typography>

            {wishlist.length === 0 ? (
                <Typography>No books in wishlist.</Typography>
            ) : (
                <>
                    <Grid container spacing={2}>
                        {wishlist.map((book) => (
                            <Grid item key={book.id} xs={12} sm={6} md={4} lg={3}>
                                <BookCard book={book} disableWishlist={true} />
                            </Grid>
                        ))}
                    </Grid>

                    <div style={{ marginTop: "20px" }}>
                        <Button
                            variant="contained"
                            color="primary"
                            onClick={rentAll}
                            style={{ marginRight: "10px" }}
                        >
                            Rent All
                        </Button>
                        <Button variant="outlined" color="error" onClick={clearWishlist}>
                            Clear Wishlist
                        </Button>
                    </div>
                </>
            )}
        </div>
    );
}
