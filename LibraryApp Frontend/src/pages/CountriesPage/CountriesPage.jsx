import React, {useState} from 'react';
import {Box, CircularProgress,Button} from "@mui/material";
import CountriesGrid from "../../components/CountryComponent/CountriesGrid/CountriesGrid.jsx";
import useCountries from "../../hooks/useCountries.js";
import "./CountriesPage.css";
import AddCountryDialog from "../../components/CountryComponent/AddCountryDialog/AddCountryDialog.jsx";

const CountriesPage=()=>{
    const{countries,loading,onDelete,onEdit,onAdd}=useCountries();
    const [addCountryDialog, setAddCountryDialog] = useState(false);

    return (
        <>
            <Box className="page-box">
                {loading && (
                    <Box className="progress-box">
                        <CircularProgress/>
                    </Box>
                )}

                {
                    !loading &&
                    <>
                        <Box sx={{display: "flex", justifyContent: "flex-end", mb: 2}}>
                            <Button variant="contained" color="primary" onClick={() => setAddCountryDialog(true)}>
                                Add Country
                            </Button>
                        </Box>
                        <CountriesGrid countries={countries} onEdit={onEdit} onDelete={onDelete} />
                    </>
                }
            </Box>
            <AddCountryDialog
                open={addCountryDialog}
                onClose={()=>setAddCountryDialog(false)}
                onAdd={onAdd}
            />

        </>
    );

}
export default CountriesPage;