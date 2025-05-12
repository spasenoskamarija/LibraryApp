import React, {useState} from 'react';
import InfoIcon from '@mui/icons-material/Info';
import EditIcon from '@mui/icons-material/Edit';
import DeleteIcon from '@mui/icons-material/Delete';
import {Box, Button, Card, CardActions, CardContent, Typography} from "@mui/material";
import EditAuthorDialog from "../EditAuthorDialog/EditAuthorDialog.jsx"
import DeleteAuthorDialog from "../DeleteAuthorDialog/DeleteAuthorDialog.jsx"

import {useNavigate} from "react-router";

const AuthorCard = ({author,onEdit,onDelete}) => {

    const [editAuthorDialogOpen, setEditAuthorDialogOpen] = useState(false);
    const [deleteAuthorDialogOpen, setDeleteAuthorDialogOpen] = useState(false);

    return (
        <>
            <Card sx={{boxShadow: 3, borderRadius: 2, p: 1}}>
                <CardContent>
                    <Typography variant="h5">{author.name}</Typography>
                    <Typography variant="h5">{author.surname}</Typography>
                    <Typography variant="body1" sx={{textAlign: "right", fontSize: "1.00rem"}}>CountyId: {author.countryId}</Typography>
                </CardContent>
                <CardActions sx={{justifyContent: "space-between"}}>
                    {/*<Button*/}
                    {/*    size="small"*/}
                    {/*    color="info"*/}
                    {/*    startIcon={<InfoIcon/>}*/}
                    {/*    // onClick={() => navigate(`/books/${book.id}`)}*/}
                    {/*>*/}
                    {/*    Info*/}
                    {/*</Button>*/}
                    <Button
                        size="small" color="info" startIcon={<InfoIcon/>}>Info
                    </Button>
                    <Box>
                        <Button
                            size="small"
                            color="warning"
                            startIcon={<EditIcon/>}
                            sx={{mr: "0.25rem"}}
                            onClick={() => setEditAuthorDialogOpen(true)}
                        >
                            Edit
                        </Button>
                        <Button
                            size="small"
                            color="error"
                            startIcon={<DeleteIcon/>}
                            onClick={() => setDeleteAuthorDialogOpen(true)}
                        >
                            Delete
                        </Button>
                    </Box>
                </CardActions>
            </Card>
            <EditAuthorDialog
                open={editAuthorDialogOpen}
                onClose={() => setEditAuthorDialogOpen(false)}
                author={author}
                onEdit={onEdit}
            />
            <DeleteAuthorDialog
                open={deleteAuthorDialogOpen}
                onClose={() => setDeleteAuthorDialogOpen(false)}
                author={author}
                onDelete={onDelete}
            />

        </>
    );
};
export default AuthorCard;



