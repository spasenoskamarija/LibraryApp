import { useState, useEffect } from "react";

const API_URL = "http://localhost:9090/api/wishlist";

export default function useWishlist(username) {
    const [wishlist, setWishlist] = useState([]);
    const [loading, setLoading] = useState(true);

    // 🔹 Fetch wishlist при mount
    useEffect(() => {
        if (!username) return;

        fetch(`${API_URL}?username=${username}`)
            .then(async res => {
                if (!res.ok) throw new Error("Failed to fetch wishlist");
                const text = await res.text();
                return text ? JSON.parse(text) : null;
            })
            .then(data => {
                if (data && data.bookDtoList) {
                    setWishlist(data.bookDtoList);
                } else {
                    setWishlist([]);
                }
                setLoading(false);
            })
            .catch(err => {
                console.error("Error fetching wishlist:", err);
                setLoading(false);
            });
    }, [username]);

    // 🔹 Add book to wishlist
    const addToWishlist = (bookId) => {
        fetch(`${API_URL}/add/${bookId}?username=${username}`, {
            method: "POST",
        })
            .then(async res => {
                if (!res.ok) throw new Error("Failed to add book");
                const text = await res.text();
                return text ? JSON.parse(text) : null;
            })
            .then(data => {
                if (data && data.bookDtoList) {
                    setWishlist(data.bookDtoList);
                } else {
                    // ако нема body, освежи ја листата со GET
                    return fetch(`${API_URL}?username=${username}`)
                        .then(r => r.json())
                        .then(d => setWishlist(d.bookDtoList || []));
                }
            })
            .catch(err => console.error("Error adding book:", err));
    };

    // 🔹 Rent all books
    const rentAll = () => {
        fetch(`${API_URL}/rent?username=${username}`, { method: "POST" })
            .then(() => setWishlist([]))
            .catch(err => console.error("Error renting books:", err));
    };

    // 🔹 Clear wishlist
    const clearWishlist = () => {
        fetch(`${API_URL}/delete?username=${username}`, { method: "DELETE" })
            .then(() => setWishlist([]))
            .catch(err => console.error("Error clearing wishlist:", err));
    };

    return { wishlist, loading, addToWishlist, rentAll, clearWishlist };
}
