import React, { useState } from "react";
import {
    Card,
    CardMedia,
    CardContent,
    Typography,
    CardActions,
    IconButton,
    Box,
    Tooltip
} from "@mui/material";
import InfoIcon from "@mui/icons-material/Info";
import EditIcon from "@mui/icons-material/Edit";
import DeleteIcon from "@mui/icons-material/Delete";
import FavoriteBorderIcon from "@mui/icons-material/FavoriteBorder";
import FavoriteIcon from "@mui/icons-material/Favorite";

import EditBookDialog from "../EditBookDialog/EditBookDialog.jsx";
import DeleteBookDialog from "../DeleteBookDialog/DeleteBookDialog.jsx";

const BookCard = ({ book, onEdit, onDelete, onInfo, addToWishlist }) => {
    const [editBookDialogOpen, setEditBookDialogOpen] = useState(false);
    const [deleteBookDialogOpen, setDeleteBookDialogOpen] = useState(false);
    const [wishlisted, setWishlisted] = useState(false);


    return (
        <>
            <Card
                sx={{
                    borderRadius: 3,
                    boxShadow: 4,
                    transition: "transform 0.2s, box-shadow 0.2s",
                    "&:hover": {
                        transform: "translateY(-6px)",
                        boxShadow: 8
                    },
                    display: "flex",
                    flexDirection: "column",
                    height: "100%"
                }}
            >
                {/* Слика од книгата */}
                <CardMedia
                    component="img"
                    height="220"
                    image={book.coverUrl || "/placeholder-book.jpg"}
                    alt={book.name}
                    sx={{ objectFit: "cover", borderTopLeftRadius: 12, borderTopRightRadius: 12 }}
                />

                {/* Информации */}
                <CardContent sx={{ flexGrow: 1 }}>
                    <Typography variant="h6" fontWeight="bold" gutterBottom>
                        {book.name}
                    </Typography>
                    <Typography variant="body2" color="text.secondary">
                        {book.category}
                    </Typography>
                    <Typography variant="body2" color="text.secondary">
                        Author: {book.authorName}
                    </Typography>
                    <Typography variant="caption" color="text.secondary">
                        {book.availableCopies} available copies
                    </Typography>
                </CardContent>

                {/* Копчиња */}
                <CardActions sx={{ justifyContent: "space-between", px: 2 }}>
                    <Box>
                        <Tooltip title="More info">
                            <IconButton color="info" onClick={() => onInfo(book)}>
                                <InfoIcon />
                            </IconButton>
                        </Tooltip>
                        <Tooltip title="Edit book">
                            <IconButton color="warning" onClick={() => setEditBookDialogOpen(true)}>
                                <EditIcon />
                            </IconButton>
                        </Tooltip>
                        <Tooltip title="Delete book">
                            <IconButton color="error" onClick={() => setDeleteBookDialogOpen(true)}>
                                <DeleteIcon />
                            </IconButton>
                        </Tooltip>
                        <Tooltip title="Add to Wishlist">
                            <IconButton
                                color="secondary"
                                onClick={() => {
                                    addToWishlist(book.id);
                                    setWishlisted(!wishlisted);
                                }}
                            >
                                {wishlisted ? <FavoriteIcon /> : <FavoriteBorderIcon />}
                            </IconButton>
                        </Tooltip>

                    </Box>
                </CardActions>
            </Card>

            {/* Edit/Delete дијалози */}
            <EditBookDialog
                open={editBookDialogOpen}
                onClose={() => setEditBookDialogOpen(false)}
                book={book}
                onEdit={onEdit}
            />
            <DeleteBookDialog
                open={deleteBookDialogOpen}
                onClose={() => setDeleteBookDialogOpen(false)}
                book={book}
                onDelete={onDelete}
            />
        </>
    );
};

export default BookCard;
