import BooksPage from "./pages/BooksPage/BooksPage.jsx";
import {BrowserRouter, Routes, Route} from "react-router";
import Layout from "./pages/Layout/Layout.jsx";
import AuthorsPage from "./pages/AuthorsPage/AuthorsPage.jsx";
import CountriesPage from "./pages/CountriesPage/CountriesPage.jsx"
import HomePage from "./pages/HomePage/HomePage.jsx";
import StatisticsPage from "./pages/StatisticsPage/StatisticsPage.jsx";
import WishlistPage from "./pages/WishlistPage/WishlistPage.jsx";

const App = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Layout/>}>
                    <Route index element={<HomePage/>}/>
                    <Route path="countries" element={<CountriesPage/>}/>
                    <Route path="authors" element={<AuthorsPage/>}/>
                    <Route path="books" element={<BooksPage />}/>
                    <Route path="statistics" element={<StatisticsPage />}/>
                    <Route path="wishlist" element={<WishlistPage username="andrej13" />} />
                </Route>
            </Routes>
        </BrowserRouter>
    );
};

export default App;
